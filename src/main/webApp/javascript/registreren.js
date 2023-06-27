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

    console.log(data);

    const email = data.email;
    const wachtwoord = data.wachtwoord;
    const herhaalWachtwoord = registrerenForm.herWachtwoord.value;

    if(isIngevuld(data, herhaalWachtwoord) === false) {
        alert("Niet alles is ingevuld");
        registrerenForm.wachtwoord.value = "";
        registrerenForm.herWachtwoord.value = "";
    } else {
        if (wachtwoord.length < 8) {
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
                })}
    }
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

function isIngevuld(gegevens, herhaalWachtwoord) {
    let ingevuld = false;
    if (gegevens.voornaam !== "" && gegevens.achternaam !== "" && gegevens.woonplaats !== "" && gegevens.straatnaam !== ""
        && gegevens.huisNummer  !== "" && gegevens.telefoonnummer !== "" && gegevens.email !== "") {
        ingevuld = true;
    }
    return ingevuld;
}
