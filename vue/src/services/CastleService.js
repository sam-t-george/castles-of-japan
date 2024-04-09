import axios from 'axios';

export default {

    listCastles() {
        return axios.get('/castles');
    },
    searchForCastles(name) {
        let url = '/castle/search?';
        if (name) {
            url += name.toLowerCase().replace(/\s/g, '');
        }
        return axios.get(url);
    },

    getCastleById(castleId) {
        return axios.get
    }
}