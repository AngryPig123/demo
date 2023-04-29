const requestFail = () => {
    alert("알 수 없는 이유로 통신에 실패하였습니다. 관리자에게 문의하세요.");
}

const restProtocol = (url, method, payLoad, dataType = "json", thenMethod, catchMethod, finallyMethod, successUrl) => {

    fetch(url, {
        method: method,
        body: payLoad,
    })
        .then((response) => {

            if (response.status !== 200) {
                if (dataType === "json") {
                    return response.json()
                } else if (dataType === "text") {
                    return response.text;
                } else if (dataType === "blob") {
                    return response.blob
                } else {
                    return response.formData;
                }
            } else {
                location.href = successUrl;
            }

        })
        .then((data) =>
            thenMethod(data)
        )
        .catch((error) => {
            catchMethod(error)
        })
        .finally(() =>
            finallyMethod()
        );
}

const setErrorField = (errorText, errorFieldId) => {
    document.querySelector("#" + errorFieldId).textContent = errorText;
}
const cleanErrorFiled = (map) => {
    map.forEach((v, k) => {
        document.querySelector("#" + k).textContent = "";
    })
}

const objectToMap = (object) => {
    return new Map(Object.entries(object));
}
