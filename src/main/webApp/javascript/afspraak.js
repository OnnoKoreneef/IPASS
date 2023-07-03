const afspraakForm = document.getElementById("afspraakForm");

afspraakForm.addEventListener("submit", createAfspraak);

async function createAfspraak(event) {
    event.preventDefault();
    const data = {
        datum: afspraakForm.datum.value,
        beginTijd: afspraakForm.beginTijd.value,
        eindTijd: afspraakForm.eindTijd.value,
        woonplaats: afspraakForm.woonplaats.value,
        straatnaam: afspraakForm.straatnaam.value,
        huisNummer: afspraakForm.huisNummer.value,
        onderwerp: afspraakForm.onderwerp.value,
    }

    if (isIngevuld(data) === false) {
        alert("Niet alles is ingevuld");
    } else if (inToekomst(data.datum) === false) {
        alert("Datum is in het verleden of vandaag");
    } else if (beginTijdVoorEindTijd(data.beginTijd, data.eindTijd) === false) {
        alert("Begintijd is niet voor eindtijd");
    } else {
        const emailKlant = "onnokoreneef@hotmail.nl"
        const url = `http://localhost:8080/restservices/afspraken/${emailKlant}`;
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
                const encodedEmail = encodeURIComponent(emailKlant);
                window.location.href = `../pages/gegevens.html?email=${encodedEmail}`;
            }).catch((error) => {
                console.log(error);
            })
    }
}

function isIngevuld(gegevens) {
    let ingevuld = false;
    if (gegevens.datum !== "" && gegevens.beginTijd !== "" && gegevens.eindTijd !== "" && gegevens.woonplaats !== ""
        && gegevens.straatnaam !== "" && gegevens.huisNummer !== "" && gegevens.onderwerp !== "") {
        ingevuld = true;
    }
    return ingevuld;
}

function beginTijdVoorEindTijd(beginTijd, eindTijd) {
    let beginVoorEind = false;
    if (beginTijd < eindTijd) {
        beginVoorEind = true;
    }
    return beginVoorEind;
}

function inToekomst(datum) {
    let toekomst = false;
    const vandaag = new Date();
    const newDatum = new Date(datum);
    if (vandaag < newDatum) {
        toekomst = true;
    }
    return toekomst;
}