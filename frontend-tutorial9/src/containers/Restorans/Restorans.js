import React, { Component } from 'react';
import Restoran from '../../components/Restoran/Restoran';
import classes from "./Restorans.module.css";
import axios from '../../axios-restoran';
import Modal from '../../components/UI/Modal/Modal';
import Button from '../../components/UI/Button/Button';

class Restorans extends Component{
    constructor(props){
        super(props);
        this.state = {
            restorans: [],
            restoransDatabase: [],
            isLoading: true,
            isCreate: false,
            isEdit: false,
            nama: "",
            alamat: "",
            nomorTelepon: "",
            rating: "",
            thisPage: 1,
            restoransByPage: 5,
            upperPage: 3,
            lowerPage: 0
        }
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick = event => {
        this.setState({
            thisPage: Number(event.target.id)
        });
    }

    searchHandler = event => {
        const query = event.target.value;
        const restoransData = this.state.restoransDatabase;
        const fetchedRestorans = [];
        for (let key in restoransData) {
            if(restoransData[key].nama.toLowerCase().startsWith(query.toLowerCase())){
                fetchedRestorans.push({
                    ...restoransData[key]
                });
            }
        }

        this.setState({
            restorans: fetchedRestorans
        })
    }

    addRestoranHandler = () => {
        this.setState({ isCreate: true });
    }

    canceledHandler = () => {
        this.setState({ isCreate: false, isEdit: false });
    }

    editRestoranHandler(restoran) {
        this.setState({
            isEdit: true,
            idRestoran: restoran.idRestoran,
            nama: restoran.nama,
            nomorTelepon: restoran.nomorTelepon,
            rating: restoran.rating,
            alamat: restoran.alamat
        })
    }
    
    changeHandler = event => {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }

    submitAddRestoranHandler = event => {
        console.log("adding")
        event.preventDefault();
        this.setState({ isLoading: true });
        this.addRestoran();
        this.canceledHandler();
        this.setState({
            nama: "",
            alamat: "",
            nomorTelepon: "",
            rating: ""
        });
    }

    async addRestoran() {
        const restoranToAdd = {
            nama: this.state.nama,
            alamat: this.state.alamat,
            nomorTelepon: this.state.nomorTelepon,
            rating: this.state.rating
        }

        await axios.post("/restoran", restoranToAdd);
        await this.loadRestorans();
    }

    submitEditRestoranHandler = event => {
        console.log("editing")
        event.preventDefault();
        this.setState({ isLoading: true });
        this.editRestoran();
        this.canceledHandler();
    }

    async editRestoran() {
        const restoranToEdit = {
            idRestoran: this.state.idRestoran,
            nama: this.state.nama,
            alamat: this.state.alamat,
            nomorTelepon: this.state.nomorTelepon,
            rating: this.state.rating
        }

        await axios.put("/restoran/" + this.state.idRestoran, restoranToEdit);
        await this.loadRestorans();
        this.canceledHandler();
    }

    async deleteRestoranHandler(restoranId){
        await axios.delete(`/restoran/${restoranId}`);
        await this.loadRestorans();
    }

    componentDidMount(){
        this.loadRestorans();
    }

    loadRestorans = async () => {
        const fetchedRestorans = [];
        const response = await axios.get("/restorans");
        for (let key in response.data) {
            fetchedRestorans.push({
                ...response.data[key]
            });
        }
        this.setState({
            restorans: fetchedRestorans,
            restoransDatabase: fetchedRestorans
        });
    }

    renderForm() {
        const { isEdit } = this.state;
        return (
            <form>
                <input 
                    className={classes.Input}
                    name="nama"
                    type="text"
                    placeholder="Nama"
                    value={this.state.nama}
                    onChange={this.changeHandler}
                />
                <input 
                    className={classes.Input}
                    name="nomorTelepon"
                    type="number"
                    placeholder="Nomor Telepon"
                    value={this.state.nomorTelepon}
                    onChange={this.changeHandler}
                />
                <textarea 
                    className={classes.TextArea}
                    name="alamat"
                    type="text"
                    placeholder="Alamat"
                    value={this.state.alamat}
                    onChange={this.changeHandler}
                />
                <input 
                    className={classes.Input}
                    name="rating"
                    type="number"
                    placeholder="Rating"
                    value={this.state.rating}
                    onChange={this.changeHandler}
                />
                <Button btnType="Danger" onClick={this.canceledHandler}>
                    CANCEL
                </Button>
                <Button btnType="Success" onClick={ isEdit ? this.submitEditRestoranHandler : this.submitAddRestoranHandler}>
                    SUBMIT
                </Button>
            </form>
        );
    }
    // shouldComponentUpdate(nextProps, nextState){
    //     console.log("shouldComponentUpdate()");
    //     return true;
    // }

    // loadingHandler = () => {
    //     const currentIsLoading = this.state.isLoading;
    //     this.setState( {isLoading: !(currentIsLoading)} );
    //     console.log(this.state.isLoading);
    // }

    render(){
        const { restorans, restoransDatabase, thisPage, restoransByPage, upperPage, lowerPage } = this.state;
        const indexOfLastToDo = thisPage * restoransByPage;
        const indexOfFirstToDo = indexOfLastToDo - restoransByPage;
        const currentRestorans = restorans.slice(indexOfFirstToDo, indexOfLastToDo);
        const restoransRender = currentRestorans.map((restoran) => {
            return (
                <Restoran
                    key={restoran.id}
                    nama={restoran.nama}
                    alamat={restoran.alamat}
                    nomorTelepon={restoran.nomorTelepon}
                    edit={() => this.editRestoranHandler(restoran)}
                    delete={() => this.deleteRestoranHandler(restoran.idRestoran)}
                />
            )
        });

        const pageNumbers = [];
        for (let i = 1; i <= Math.ceil(restorans.length / restoransByPage); i++){
            pageNumbers.push(i);
        }

        const renderPageNums = pageNumbers.map(number => {
            if (number === 1 && thisPage === 1){
                return (
                    <button key={number} className='active' id={number}>
                        <a href='#' id={number} onClick={this.handleClick}> {number} </a>
                    </button>
                )
            }
            else if ((number < upperPage +1) && number > lowerPage) {
                return(
                    <button key={number} id={number}>
                        <a href='#' id={number} onClick={this.handleClick}> {number} </a>
                    </button>
                )
            }
        });
        
        return(
            <React.Fragment>
                <Modal show={this.state.isCreate || this.state.isEdit}
                    modalClosed={this.canceledHandler}>
                    {this.renderForm()}
                </Modal>
                <div className={classes.Title}> All Restorans</div>
                <div className={classes.ButtonLayout}>
                    <button
                        className={classes.AddRestoranButton}
                        onClick={this.addRestoranHandler}
                    >
                        + Add New Restoran
                    </button>
                </div>
                <div className={classes.SearchBarLayout}>
                    <input
                        className={classes.Input}
                        type="text"
                        placeholder="Search"
                        onChange={this.searchHandler}
                    />
                </div>
                <div className={classes.Restorans}>
                    {/* {this.state.restorans &&
                        this.state.restorans.map(restoran =>
                            <Restoran
                                key={restoran.id}
                                nama={restoran.nama}
                                alamat={restoran.alamat}
                                nomorTelepon={restoran.nomorTelepon}
                                edit={() => this.editRestoranHandler(restoran)}
                                delete={() => this.deleteRestoranHandler(restoran.idRestoran)}
                            />
                    )} */}
                    {restoransRender}
                </div>
                <div className={classes.pageNum}>
                    <ul id="page-numbers">
                        {renderPageNums}
                    </ul>
                </div>
            </React.Fragment>
        );
    }
}
export default Restorans;
