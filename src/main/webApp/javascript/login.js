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
            break;
        }
    }
    if (ingelogd) {
        document.getElementById("login").innerHTML = "Mijn account";
        // await laadGegevens(email);
        console.log("testing")
        // window.location.href = "../pages/gegevens.html";
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