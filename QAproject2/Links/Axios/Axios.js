// ALWAYS USE 
'use strict';

let createUserBtn = document.querySelector("#createUserBtn");


let createUser = () =>{
    let User = {
        "name": "james",
        "phoneNumber": "123"
    }
    console.log(User);

    axios.post("http://localhost:8080/user/create", User)
    .then((response) => {
        console.log(response);
       // getAll();
    })
    .catch((err) => {
        console.error(err);
    });
};

// let getAll = () => {
//     ReadAllDiv.innerHTML = "";
//     axios.get("http://localhost:8080/user/getAll")
//         .then((response) => {
//             console.log(response);
//             displayCharacter(response.data)
//         })
//         .catch((err) => {
//             console.error(err);
//         });
// }


//readAllBtn.addEventListener("click", getAll);
createUserBtn.addEventListener("click",createUser);