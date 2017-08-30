import * as _ from "lodash";

// state argument is not the entire application state
// it is only the state the reducer is responsible for

export default function (currentState = null, action) {

    if (_.eq(action.type, 'RESULT_SELECTED')) {
        return action.payload
    }

    return currentState;

}