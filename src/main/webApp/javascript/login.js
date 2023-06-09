import {ingelogd, setIngelogd} from "./shared.js";

const loginForm = document.getElementById("loginForm")
const loginButton = document.getElementById("loginButton");

loginButton.addEventListener("click", login);
async function login(event) {
    event.preventDefault();
    const emailForm = loginForm.emailForm.value;
    const wachtwoord = loginForm.wachtwoord.value;
    const klanten = await getKlantenLijst();

    for (const klant of klanten) {
        if (klant.email === emailForm && klant.wachtwoord === wachtwoord) {
            setIngelogd(true);
            break;
        }
    }
    if (ingelogd) {
        const encodedEmail = encodeURIComponent(emailForm);
        window.location.href = `../pages/gegevens.html?email=${encodedEmail}`;
    } else {
        alert("wachtwoord of email klopt niet");
    }
}

async function getKlanten() {
    const url = "http://localhost:8080/restservices/klanten";
    return fetch(url).then((resolve) => resolve.json());
}

async function getKlantenLijst() {
    const klantenLijst = []
    const klanten = await getKlanten();
    klanten.forEach(klant => klantenLijst.push(klant))
    return klantenLijst;
}