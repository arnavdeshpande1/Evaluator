function fun() {
    const url ='http://localhost:8080/checker';
    const headers = {
        "Content-Type": "application/json",
    }


    fetch(url, { method: 'POST', headers: headers})
        .then((res) => {
            return res.json()
        })
}