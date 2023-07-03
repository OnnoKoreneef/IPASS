const offerteForm = document.getElementById("offerteForm");
offerteForm.addEventListener("submit", vraagOfferte);

async function vraagOfferte(event){
    event.preventDefault();
    const data = {
        klantType: offerteForm.klantType.value,
        onderwerp: onderwerpenLijst(),
        onderdeel: onderdelenLijst(),
        omschrijving: offerteForm.omschrijving.value,
    }

    if (isIngevuld(data) === false) {
        alert("Niet alles is ingevuld");
    }
    else if(data.omschrijving.length > 500) {
        alert(`Omschrijving is te lang max 500 tekens is nu ${data.omschrijving.length}`);
    } else {
        const email = "onnokoreneef@hotmail.nl";
        const url = `http://localhost:8080/restservices/offertes/${email}`;
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
}

function isIngevuld(gegevens) {
    let ingevuld = false;
    if (gegevens.klantType !== "" && gegevens.onderwerp.length > 0 && gegevens.onderdeel.length > 0
        && gegevens.omschrijving !== "") {
        ingevuld = true;
    }
    return ingevuld;
}

function onderwerpenLijst() {
    let onderwerpenLijst = [];
    let onderwerpen = [
        { checkbox: offerteForm.plantmatig, value: 'planmatig onderhoud' },
        { checkbox: offerteForm.renovatie, value: 'renovatie' },
        { checkbox: offerteForm.duurzaamheid, value: 'duurzaamheid' },
        { checkbox: offerteForm.advies, value: 'advies' },
        { checkbox: offerteForm.begeleiding, value: 'begeleiding' }
    ]
    for (const onderwerp of onderwerpen) {
        if (onderwerp.checkbox.checked) {
            onderwerpenLijst.push(onderwerp.value);
        }
    }
    return onderwerpenLijst;
}

function onderdelenLijst() {
    let onderdelenLijst = [];
    let onderdelen = [
        { checkbox: offerteForm.installaties, value: 'installaties' },
        { checkbox: offerteForm.kozijnen, value: 'kozijnen' },
        { checkbox: offerteForm.gevel, value: 'gevel' },
        { checkbox: offerteForm.beton, value: 'beton' },
        { checkbox: offerteForm.dak, value: 'dak' },
        { checkbox: offerteForm.overig, value: 'overig' }
    ];
    for (const onderdeel of onderdelen) {
        if (onderdeel.checkbox.checked) {
            onderdelenLijst.push(onderdeel.value);
        }
    }
    return onderdelenLijst;
}