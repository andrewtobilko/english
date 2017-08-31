export default function searchQueryChangedActionCreator(searchQuery) {

    return {
        type: 'SEARCH_QUERY_CHANGED',
        payload: searchQuery
    };

}