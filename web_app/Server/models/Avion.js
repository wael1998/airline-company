const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const AvionShema = new Schema({
  id: { type: String },
  capacite: { type: Number },
  type: { type: String },
  constructeur: { type: String},
});

module.exports = mongoose.model("Avion", AvionShema);
