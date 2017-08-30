import {combineReducers} from 'redux';
import ResultReducer from './results.reducer'

const combinedReducer = combineReducers({
    results: ResultReducer
});

export default combinedReducer;