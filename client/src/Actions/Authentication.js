import {addToAPI, addToBase} from "../Services/URL/Resolver";
import {VIEW} from "../Services/Response/Items";

const LOGIN_URL = "/auth/login";
const SIGNUP_URL = "/auth/signUp";

export function login(jsonData) {
    return fetch(addToAPI(LOGIN_URL), {
        method: 'POST',
        credentials: 'include',
        headers: {
            "Content-Type": "application/json"
        },
        body: jsonData
    })
      .then(response => response.json())
      .catch(e => console.warn(e))
      .then(data => window.location = addToBase(data[VIEW]));
}

export function signUp(jsonData) {
    return fetch(addToAPI(SIGNUP_URL), {
        method: 'POST',
        credentials: 'include',
        headers: {
            "Content-Type": "application/json"
        },
        body: jsonData
    })
        .then(response => response.json())
        .catch(e => console.warn(e))
        .then(data => window.location = addToBase(data[VIEW]));
}
