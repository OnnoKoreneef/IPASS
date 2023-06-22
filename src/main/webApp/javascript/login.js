const loginForm = document.getElementById("loginForm")
const loginButton = document.getElementById("loginButton");

loginButton.addEventListener("click", login);

async function login(event) {
    let ingelogd = false
    event.preventDefault();
    const email = loginForm.email.value;
    const wachtwoord = loginForm.wachtwoord.value;
    const klanten = await getKlantenLijst();
    for (const klant of klanten) {
        if (klant.email === email && klant.wachtwoord === wachtwoord) {
            ingelogd = true;
            break;
        }
    }
    if (ingelogd) {
        window.open("../index.html");
    } else {
        alert("wachtwoord of email klopt niet");
    }
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