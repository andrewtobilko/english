import {combineReducers} from 'redux';
import ResultReducer from './results.reducer'
import SelectedResultReducer from './active-result.reducer'

export default combineReducers(
    {
        results: ResultReducer,
        selectedResult: SelectedResultReducer
    }
);