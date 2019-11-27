import React from 'react';
import List from "./components/List";
import dummyItems from "./items.json";
import EmptyState from './components/EmptyState';

export default class App extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      favItems: [],
      showFav: false
    };

    this.showFavChange = this.showFavChange.bind(this);
  }

  showFavChange(){
    this.setState({
      showFav: !this.state.showFav
    });
  }
  
  render() {
    const { favItems } = this.state;

    let emptyState;
    if (favItems.length == 0) {
      emptyState = <EmptyState/>
    }
    
    const showFavorite = this.state.showFav ?
                          <div className="col-sm">
                            <List
                              title="My Favorite"
                              items={favItems}
                              onItemClick={this.handleItemClick2}
                            />
                            {emptyState}
                          </div>
                          : null;

    return (
      <div className="container-fluid">
        <h1 className="text-center">
          Welcome! 
          <small>Class-based</small>
        </h1>
        <div className="row">
          <div className="col text-right">
            <label><input type="checkbox" checked={this.state.showFav}
            onChange={this.showFavChange}/> Show Favorite</label>
          </div>
        </div>
        <div className="container pt-3">
          <div className="row">
            <div className="col-sm">
              <List
                title="Our Menu"
                items={dummyItems}
                onItemClick={this.handleItemClick1}
              />
            </div>
            {showFavorite}
          </div>
        </div>
      </div>
    );
  }

  handleItemClick1 = item => {
    const newItems = [...this.state.favItems];
    const newItem = { ...item};
    
    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    if (targetInd < 0) newItems.push(newItem);

    this.setState({ favItems: newItems });
  };

  handleItemClick2 = item => {
    const newItems = [...this.state.favItems];
    const newItem = { ...item};
    
    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    if (targetInd < 0) newItems.push(newItem);
    else newItems.splice(targetInd, 1);

    this.setState({ favItems: newItems });
  };
}
