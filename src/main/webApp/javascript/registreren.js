const registrerenForm = document.getElementById("registerenForm");

registrerenForm.addEventListener("submit", registreren);

async function registreren(event) {
    event.preventDefault();
    const data = {
        voornaam: registrerenForm.voornaam.value,
        achternaam: registrerenForm.achternaam.value,
        woonplaats: registrerenForm.woonplaats.value,
        straatnaam: registrerenForm.straatnaam.value,
        huisNummer: registrerenForm.huisNummer.value,
        telefoonnummer: registrerenForm.telefoonnummer.value,
        email: registrerenForm.emailForm.value,
        wachtwoord: registrerenForm.wachtwoord.value,
    }

    const email = data.email;
    const wachtwoord = data.wachtwoord;
    const herhaalWachtwoord = registrerenForm.herWachtwoord.value;
    const emailLijst = await getEmailLijst();

    if(isIngevuld(data) === false) {
        alert("Niet alles is ingevuld");
        registrerenForm.wachtwoord.value = "";
        registrerenForm.herWachtwoord.value = "";
    } else if (emailLijst.includes(email)) {
        alert("Er bestaat al een account met dit email");
        registrerenForm.wachtwoord.value = "";
        registrerenForm.herWachtwoord.value = "";
    } else if (containsOnlyNumbers(data.telefoonnummer) === false) {
        alert("Telefoon number bevat iets anders dan getallen");
        registrerenForm.wachtwoord.value = "";
        registrerenForm.herWachtwoord.value = "";
    } else if (validEmail(email) === false) {
        alert("Dit is niet geldig email address");
        registrerenForm.wachtwoord.value = "";
        registrerenForm.herWachtwoord.value = "";
    } else if (data.telefoonnummer.length !== 10) {
        alert("Telefoonnummer heeft niet de goeie lengte");
        registrerenForm.wachtwoord.value = "";
        registrerenForm.herWachtwoord.value = "";
    } else if (wachtwoord.length < 8) {
        alert("Wachtwoord moet minstens 8 karakters zijn");
        registrerenForm.wachtwoord.value = "";
        registrerenForm.herWachtwoord.value = "";
    } else if (containsNumber(wachtwoord) === false || containsSpecialCharacter(wachtwoord) === false || containsUppercase(wachtwoord) === false || containsLowercase(wachtwoord) === false) {
        alert("Wachtwoord moet een hoofdletter, een cijfer en een speciaal teken bevatten");
        registrerenForm.wachtwoord.value = "";
        registrerenForm.herWachtwoord.value = "";
    } else if (wachtwoord !== herhaalWachtwoord) {
        alert("Wachtwoord en herhaal wachtwoord zijn niet hetzelfde");
        registrerenForm.wachtwoord.value = "";
        registrerenForm.herWachtwoord.value = "";
    } else {
        const url = "http://localhost:8080/restservices/klanten";
        const options = {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(data),
        }

        await fetch(url, options)
            .then((response) => response.json())
            .then((data) => {
                window.location.href = `../pages/gegevens.html?email=${encodeURIComponent(email)}`;
                console.log(data);
            }).catch((error) => {
                console.log(error);
            })
    }
}

async function getKlanten(email) {
    const url = `http://localhost:8080/restservices/klanten`
    return fetch(url).then((response) => response.json());
}

async function getEmailLijst() {
    const emailLijst = []
    const klanten = await getKlanten();
    klanten.forEach(klant => emailLijst.push(klant.email))
    return emailLijst;
}

function containsNumber(string) {
    const pattern = /\d/;
    return pattern.test(string);
}

function containsSpecialCharacter(string) {
    const pattern = /[!@#$%^&*(),.?":{}|<>]/;
    return pattern.test(string);
}

function containsLowercase(string) {
    const pattern = /[a-z]/;
    return pattern.test(string);
}

function containsUppercase(string) {
    const pattern = /[A-Z]/;
    return pattern.test(string);
}

function isIngevuld(gegevens) {
    let ingevuld = false;
    if (gegevens.voornaam !== "" && gegevens.achternaam !== "" && gegevens.woonplaats !== "" && gegevens.straatnaam !== ""
        && gegevens.huisNummer  !== "" && gegevens.telefoonnummer !== "" && gegevens.email !== "") {
        ingevuld = true;
    }
    return ingevuld;
}

function containsOnlyNumbers(string) {
    const pattern = /^\d+$/;
    return pattern.test(string);
}

function validEmail(string) {
    let valid = false
    const com = ".com";
    const nl = ".nl";
    if (string.includes(com) || string.includes(nl)) {
        valid = true;
    }
    return valid;
}
