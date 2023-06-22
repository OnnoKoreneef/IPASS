// import {addGegevens} from "./gegevens";

const loginForm = document.getElementById("loginForm")
const loginButton = document.getElementById("loginButton");
let ingelogd = false;

loginButton.addEventListener("click", login);
async function login(event) {
    event.preventDefault();
    const email = loginForm.email.value;
    const wachtwoord = loginForm.wachtwoord.value;
    const klanten = await getKlantenLijst();
    for (const klant of klanten) {
        if (klant.email === email && klant.wachtwoord === wachtwoord) {
            ingelogd = true;
            await addGegevens(klant);
            break;
        }
    }
    if (ingelogd) {
        document.getElementById("login").innerHTML = "Mijn account";
        window.location.href = "../pages/gegevens.html";
    } else {
        alert("wachtwoord of email klopt niet");
    }
}

async function addGegevens(gegevens) {
    const url = "http://localhost:8080/restservices/gegevens";
    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(gegevens),
    }
    console.log("hello")
    fetch(url, options)
        .then((response) => response.json())
        .then((gegevens) => {
            console.log("hello2");
            console.log(gegevens);
    }).catch((error) => {
            console.log(error);
        })
}

async function getKlanten() {
    const url = "http://localhost:8080/restservices/klanten";
    return fetch(url).then((resolve) => resolve.json())
}

async function getKlantenLijst() {
    const klantenLijst = []
    const klanten = await getKlanten();
    klanten.forEach(klant => klantenLijst.push(klant))
    return klantenLijst;
}