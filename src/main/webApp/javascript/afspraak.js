const afspraakForm = document.getElementById("afspraakForm");

afspraakForm.addEventListener("submit", createAfspraak);

export async function getAfspraken(email) {
    const url = `http://localhost:8080/restservices/afspraken/${email}`
    return fetch(url).then((response) => response.json());
}

async function createAfspraak(event) {
    event.preventDefault();
    const data = {
        datum: afspraakForm.datum.value,
        beginTijd: afspraakForm.beginTijd.value,
        eindTijd: afspraakForm.eindTijd.value,
        woonplaats: afspraakForm.woonplaats.value,
        straatnaam: afspraakForm.straatnaam.value,
        huisnummer: afspraakForm.huisnummer.value,
        onderwerp: afspraakForm.onderwerp.value,
    }

    const url = "http://localhost:8080/restservices/afspraken";
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