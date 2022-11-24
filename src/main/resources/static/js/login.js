// function fun() {
//     const url ='http://localhost:8080/';
//     const headers = {
//         "Content-Type": "application/json",
//     }
//
//
//     fetch(url, { method: 'POST', headers: headers})
//         .then((res) => {
//             return res.json()
//         })
// }



var base="http://localhost:8080/";

function fun(testid) {
    const p = document.getElementById("result").value;
    const b = document.getElementById("result2").value;

    fetch(base+'/test/get/{'+testid+'}', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        }
    }).then(response => response.json())
        .then((data) => {
            print(data);
            // document.getElementById("finalresult").value = data;
        });
}