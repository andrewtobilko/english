import React from 'react';
import ReactDOM from 'react-dom';
import {Provider} from 'react-redux';
import {applyMiddleware, createStore} from 'redux';

import App from './components/app.component';
import reducer from './reducers/main.reducer';

const createStoreWithMiddleware = applyMiddleware()(createStore);

const provider = (
    <Provider store={createStoreWithMiddleware(reducer)}>
        <App/>
    </Provider>
);

ReactDOM.render(provider, document.querySelector('.container'));