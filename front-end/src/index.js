import React from 'react';
import ReactDOM from 'react-dom';
import {Provider} from 'react-redux';
import {applyMiddleware, createStore} from 'redux';

import Application from './components/app.component';
import reducer from './reducers/main.reducer';

const createStoreWithMiddleware = applyMiddleware()(createStore);

const provider = (
    <Provider store={createStoreWithMiddleware(reducer)}>
        <Application/>
    </Provider>
);

ReactDOM.render(provider, document.querySelector('.container'));