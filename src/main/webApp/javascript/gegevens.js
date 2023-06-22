async function addGegevens(gegevens) {
    const url = "http://localhost:8080/restservices/gegevens";
    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(gegevens),
    }
    console.log("hello");
    fetch(url, options).then((response) => response.json())
        .then((gegevens) => {
            console.log(gegevens);
        })
        .catch((error) => {
            console.log(error);
        });
}


async function getGegevens() {
    const url = "http://localhost:8080/restservices/gegevens";
    return fetch(url).then((response) => response.json());
}


async function laadGegevens() {
    try {
        const gegevens = await getGegevens();
        const persoon = gegevens[1];
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
    } catch (Exception) {
        console.log("no data");
    }
}

await laadGegevens();
// console.log("testing");
// await addGegevens({voornaam:"Pierre", achternaam:"Koreneef", email:"phkoreneef@hotmail.com", wachtwoord:"1", woonplaats:"Bunnik", straatnaam:"Ds pasmastraat", nummer:5, telefoonnummer:"06244676398"});
// console.log("testing 2");