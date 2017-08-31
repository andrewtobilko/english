import {combineReducers} from 'redux';
import ResultReducer from './results.reducer'

export default combineReducers(
    {
        results: ResultReducer
    }
);