export default class SnakeService {
    async getSnake() {
        const response = await fetch('/restservices/snake');
        if (response.ok) {
            return response.json();
        }
        return null;
    }

    async updateSnake(updatedSnake) {
        const response = await fetch('/restservices/snake', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(updatedSnake)
        });
        return response.ok;
    }
}
