// it is an ActionCreator
// it needs to return an action

export function resultSelect(result) {
    return {
        type: 'RESULT_SELECTED',
        payload: result
    };
}