export async function addGegevens(gegevens) {
    const url = "http://localhost:8080/restservices/gegevens";
    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(gegevens),
    }

    return fetch(url, options).then((response) => response.json());
}

async function getGegevens() {
    const url = "http://localhost:8080/restservices/gegevens";
    return fetch(url).then((response) => response.json());
}

async function laadGegevens() {
    const gegevens = await getGegevens();
    const persoon = gegevens[0];
    const voornaam = persoon.voornaam;
    const achternaam = persoon.achternaam;
    const email = persoon.email;
    const woonplaats = persoon.woonplaats;
    const straatnaam = persoon.straatnaam;
    const nummer = persoon.huisnummer;
    const telefoonnummer = persoon.telefoonnummer;

    document.getElementById("voornaam").innerHTML = voornaam;
    document.getElementById("achternaam").innerHTML = achternaam;
    document.getElementById("email").innerHTML = email;
    document.getElementById("woonplaats").innerHTML = woonplaats;
    document.getElementById("straatnaam").innerHTML = straatnaam;
    document.getElementById("huisnummer").innerHTML = nummer;
    document.getElementById("telefoonnummer").innerHTML = telefoonnummer
}

await laadGegevens();