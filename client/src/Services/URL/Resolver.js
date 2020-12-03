export function addToAPI(url) {
    return process.env.REACT_APP_API_BASE_URL + url;
}

export function addToBase(url) {
    return process.env.REACT_APP_BASE_URL + url;
}