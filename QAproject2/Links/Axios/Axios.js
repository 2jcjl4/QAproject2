
// ALWAYS USE 
'use strict';

let createObjBtn = document.querySelector("#createObjBtn");
let getAllBtn = document.querySelector("#getAllBtn");
let deleteObjBtn = document.querySelector("#deleteObjBtn")
let updateObjBtn = document.querySelector("#updateObjBtn")

let readAll = document.querySelector("#readAll");

let create = () =>{
    console.log("running Create")
    let obj = {
        "name": creatureName.value, 
        "health": creatureHealth.value, 
        "damage": creatureDamage.value, 
        "speed": creatureSpeed.value, 
        "notes": creatureNotes.value 
    }
    console.log(obj);

    axios.post("http://localhost:8080/creature/create", obj)
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
    axios.get("http://localhost:8080/creature/getAll")
        .then((response) => {
            displayObjs(response.data)
        })
        .catch((err) => {
            console.error(err);
        });
}

let displayObjs = (data) => {
    for (let entry of data){
    let objList = document.createElement("div");
    objList.innerHTML=`
    ${entry.id}
    ${entry.name}
    ${entry.health}
    ${entry.damage}
    ${entry.speed}
    ${entry.notes}
    `
    readAll.appendChild(objList);
    };
}

// Delete

let removeById = (id) => {
    axios.delete(`http://localhost:8080/creature/delete/${id}`)
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

let updatefunc = () => {
    console.log("Update Running")
    let obj ={
        "name": objNameUpdate.value,
        "health": objHealthUpdate.value,
        "damage": objDamageUpdate.value,
        "speed": objSpeedUpdate.value,
        "notes": objNotesUpdate.value
    }
    axios.put(`http://localhost:8080/creature/update/${objIdUpdate.value}`, obj)
    .then((response) => {
        console.log(response);
        getAll();
    })
    .catch((err) => {
        console.error(err);
    });
}


deleteObjBtn.addEventListener("click", deleteBtnFunc);
getAllBtn.addEventListener("click", getAll);
createObjBtn.addEventListener("click",create);
updateObjBtn.addEventListener("click", updatefunc);