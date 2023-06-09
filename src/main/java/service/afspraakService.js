import {baseURL} from "../../backendServerConfig";

export default class AfspraakService {
    addAfspraak(afspraak) {
        const url = `${baseURL}/v1/afspraak`;
        const options = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(afspraak),
        }

        return fetch(url, options).then((response) => {
            if (!response.ok) {
                throw new Error(response.status);
            }
            return response.json();
        });
    }
}
