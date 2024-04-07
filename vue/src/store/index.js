import { createStore as _createStore } from 'vuex';
import axios from 'axios';
import CastleService from '../services/CastleService';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      castleList: []
    },
    actions: {
      getAllCastles(context) {
        CastleService.listCastles().then(response => {
          context.commit('SET_CASTLELIST', response.data);
        })
          .catch(err => console.error(err));
      },
      searchForCastle(context, searchTerms) {
        CastleService.searchForCastle(searchTerms.name, searchTerms.region, searchTerms.address)
          .then(response => {
            context.commit('SET_CASTLELIST', response.data);
          })
          .catch(err => console.error(err));
      }
    },
    mutations: {
      SET_CASTLELIST(state, castles) {
        state.castlelist = castles;
      },
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      }
    },
  });
  return store;
}
