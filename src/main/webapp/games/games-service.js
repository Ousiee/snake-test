export default class GamesService {
    async getGameIds() {
        const response = await fetch('/restservices/games');
        if (response.ok) {
            return response.json();
        }
        return [];
    }

    async getReplay(gameId) {
        const response = await fetch(`/restservices/games/${gameId}`);
        if (response.ok) {
            return response.json();
        }
        return null;
    }

    async removeReplay(gameId) {
        const response = await fetch(`/restservices/games/${gameId}`, {
            method: 'DELETE'
        });
        return response.ok;
    }
}
