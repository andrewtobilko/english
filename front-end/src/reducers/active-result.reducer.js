import _ from "lodash";

export default function (currentState = null, action) {
    console.log('active-result.reducer.js', currentState, action);

    if (_.eq(action.type, 'RESULT_SELECTED')) {
        return action.payload
    }

    return currentState;
}