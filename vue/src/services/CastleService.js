import axios from 'axios';

export default {

    listCastles() {
        return axios.get('/castles');
    },
    searchForCastles(name, region, address) {
        let url = '/castles?';
        if (name) {
            url += 'name=' + name;
        }
        if (name && region) {
            url += '&'; 
        }
        if (region) {
            url += 'region=' + region;
        }
        if (address) {
            url += "address=" + address
        }
        return axios.get(url);
    },

}