import {combineReducers} from 'redux';
import ResultReducer from './results.reducer'
import SelectedResultReducer from './active-result.reducer'

const combinedReducer = combineReducers({
    results: ResultReducer,
    selectedResult: SelectedResultReducer
});

export default combinedReducer;