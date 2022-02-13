const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const PiloteShema = new Schema({
  id: { type: String },
  nom: { type: String },
  prenom: { type: String },
});

module.exports = mongoose.model("Pilote", PiloteShema);