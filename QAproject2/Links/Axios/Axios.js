// ALWAYS USE 
'use strict';

let createUserBtn = document.querySelector("#createUserBtn");


let createUser = () =>{
    let User = {
        "name": name.value, "phoneNumber": phoneNumber.value
    }
    axios.post("http://localhost:8080/user/create")
    .then((Response) => {
        console.log(Response);
        getAll();
    })
    .catch((err) => {
        console.error(err);
    });
};

let getAll = () => {
    ReadAllDiv.innerHTML = "";
    axios.get("http://localhost:8080/user/getAll")
        .then((response) => {
            console.log(response);
            displayCharacter(response.data)
        })
        .catch((err) => {
            console.error(err);
        });
}


//readAllBtn.addEventListener("click", getAll);
createUserBtn.addEventListener("click",createUser);