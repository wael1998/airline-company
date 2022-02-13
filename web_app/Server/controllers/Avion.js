var Avion = require("../models/Avion");
const axios = require("axios");
const mongoose = require("mongoose");
const { body, validationResult } = require("express-validator");

const getAvion = async (req, res) => {
 
 
  axios.get('http://localhost:8082/api/avions',{
    data: {},
  }).then(resp => {
    res.status(200).json(resp.data)
  
})
.catch(function (error) {
  console.log(error);
})

};

const createAvion = async (req, res) => {
  var newAvion = new Avion();
  newAvion.id = req.body.id;
  newAvion.capacite = req.body.capacite;
  newAvion.type = req.body.type;
  newAvion.constructeur = req.body.constructeur;


  axios.post('http://localhost:8082/api/avions', newAvion)
  .then(response =>  res.status(200).json(newAvion))
  .catch(error => {
      console.error('There was an error!', error);
  });
};

const updateAvion = async (req, res) => {
  const { id } = req.params;
  axios.put(`http://localhost:8082/api/avions/${id}`, {
     id: req.body.id,
     capacite: req.body.capacite,
     type: req.body.type,
     constructeur: req.body.contructeur
  })
  .then(response => {
    console.log(response);
  })
  .catch(error => {
    console.log(err);
  });
};

const deleteAvion = async (req, res) => {
  const { id } = req.params;

  axios.delete(`http://localhost:8082/api/avions/${id}`);
  res.json({ message: "avion deleted successfully." });
};

module.exports = { getAvion, createAvion, updateAvion, deleteAvion };