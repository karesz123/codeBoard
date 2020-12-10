import {addToAPI} from "./URL/Resolver";
import {ACCESS_TOKEN } from '../Model/LocalStorage/Items';

const LOGIN_URL = "/auth/login";
const SIGNUP_URL = "/auth/signUp";

function request(url, jsonData) {
    const headers = new Headers({
        'Content-Type': 'application/json',
    })
    if(localStorage.getItem(ACCESS_TOKEN)) {
        headers.append('Authorization', 'Bearer ' + localStorage.getItem(ACCESS_TOKEN))
    }
    return fetch(url, {
        method: 'POST',
        credentials: 'include',
        headers: headers,
        body: jsonData
    })
        .then(response => response.json()
            .then(data => {
                if (!response.ok) {
                    console.log(data);
                    return Promise.reject(data);
                }
                return data;
            })
        );
}

export function login(jsonData) {
    return request(addToAPI(LOGIN_URL), jsonData);
}

export function signUp(jsonData) {
    return request(addToAPI(SIGNUP_URL), jsonData);
}
