export default class LoginService {
    isLoggedIn() {
        return !!localStorage.getItem('token');
    }

    async login(user, password) {
        const response = await fetch('/restservices/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({username: user, password: password})
        });

        if (response.ok) {
            const data = await response.json();
            localStorage.setItem('token', data.token);
            return true;
        }
        return false;
    }

    async getUser() {
        const response = await fetch('/restservices/login', {
            headers: {
                'Authorization': 'Bearer ' + localStorage.getItem('token')
            }
        });

        if (response.ok) {
            return response.json();
        }
        return null;
    }

    async logout() {
        localStorage.removeItem('token');
        await fetch('/restservices/login/logout', {
            method: 'POST'
        });
    }
}
