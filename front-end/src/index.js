import React from 'react';
import ReactDOM from 'react-dom';
import {Provider} from 'react-redux';
import {applyMiddleware, createStore} from 'redux';

import App from './components/app.component';
import reducers from './reducers/main.reducer';

const createStoreWithMiddleware = applyMiddleware()(createStore);

const provider = (
    <Provider store={createStoreWithMiddleware(reducers)}>
        <App/>
    </Provider>
);

ReactDOM.render(provider, document.querySelector('.container'));