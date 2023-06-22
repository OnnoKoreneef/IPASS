const registrerenForm = document.getElementById("registerenForm");
const registrerenButton = document.getElementById("submitRegisteren");

addEventListener("submit", registreren);

async function registreren(event) {
    event.preventDefault();
    let data = {
        voornaam: registrerenForm.voornaam.value,
        achternaam: registrerenForm.achternaam.value,
        woonplaats: registrerenForm.woonplaats.value,
        straatnaam: registrerenForm.straatnaam.value,
        huisnummer: registrerenForm.huisnummer.value,
        telefoonnummer: registrerenForm.telefoonnummer.value,
        email: registrerenForm.email.value,
        wachtwoord: registrerenForm.wachtwoord.value,
    }
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
            console.log(data);
        }).catch((error) => {
            console.log(error);
        })
}
