import axios from 'axios';

export default {

    listCastles() {
        return axios.get('/castles');
    },
    searchForCastles(name) {
        let url = '/castle/search/';
        if (name) {
            if (name.toLowerCase().includes('castle')) {
                name = name.replace('castle', '');
            }
            if (name.toLowerCase().includes('castl')) {
                name = name.replace('castl', '');
            }
            if (name.toLowerCase().includes('cast')) {
                name = name.replace('cast', '');
            }
            if (name.toLowerCase().includes('cas')) {
                name = name.replace('cas', '');
            }
            if (name.toLowerCase().includes('ca')) {
                name = name.replace('ca', '');
            }
            if (name.toLowerCase().includes('c')) {
                name = name.replace('c', '');
            }
            
            url += name.toLowerCase().replace(/\s/g, '');
        }
        return axios.get(url);
    },

    getCastleById(castleId) {
        return axios.get(`/castle/${castleId}`);
    },
    getImagesByCastleId(castleId) {
        return axios.get(`/images/${castleId}`);
    }
}