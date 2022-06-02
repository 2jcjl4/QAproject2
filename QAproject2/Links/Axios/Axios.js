// ALWAYS USE 
'use strict';

let createObjBtn = document.querySelector("#createObjBtn");
let getAllBtn = document.querySelector("#getAllBtn");
let deleteObjBtn = document.querySelector("#deleteObjBtn")


let readAll = document.querySelector("#readAll");

let create = () =>{
    let obj = {
        "name": firstName.value,
        "phoneNumber": phoneNumber.value
    }
    console.log(obj);

    axios.post("http://localhost:8080/user/create", obj)
    .then((response) => {
        console.log(response);
        getAll();
    })
    .catch((err) => {
        console.error(err);
    });
};

let getAll = () => {
    readAll.innerHTML = "";
    axios.get("http://localhost:8080/user/getAll")
        .then((response) => {
            // console.log(response);
            displayObjs(response.data)
        })
        .catch((err) => {
            console.error(err);
        });
}

let displayObjs = (data) => {
    for (let entry of data){
    let objList = document.createElement("div");
    objList.innerHTML=`${entry.id} ${entry.name} ${entry.phoneNumber}`
    readAll.appendChild(objList);
    };
}

// Delete

let removeById = (id) => {
    axios.delete(`http://localhost:8080/user/delete/${id}`)
        .then((response) => {
            console.log(response);
            getAll();
        })
        .catch((err) => {
            console.error(err);
        });
}

let deleteBtnFunc = () => {
    removeById(deleteId.value);
}



deleteObjBtn.addEventListener("click", deleteBtnFunc)
getAllBtn.addEventListener("click", getAll);
createObjBtn.addEventListener("click",create);