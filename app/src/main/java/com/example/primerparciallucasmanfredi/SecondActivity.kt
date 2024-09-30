package com.example.primerparciallucasmanfredi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    //Declaracion de variables de UI
    private lateinit var buttonVolver: Button
    private lateinit var spinnerPaises: Spinner
    private lateinit var listView: ListView

    private var paisSeleccionado: String? = null //Variable donde guardar el pais seleccionado del spinner

    var deportistasFiltrados = mutableListOf<Deportista>() //Lista para guardar los deportistas filtrados por pais
    var nombreDeportistas = mutableListOf<String>() //Lista para guardar los nombres de deportistas. Esta lista es la que se muestra en el ListView

    //Creacion de lista de Deportistas
    val listaDeportistas = listOf(
        // Argentina
        Deportista(1, "Lionel Messi", Deporte.FUTBOL, Pais.ARGENTINA, true),
        Deportista(2, "Diego Maradona", Deporte.FUTBOL, Pais.ARGENTINA, false),
        Deportista(3, "Manu Ginobili", Deporte.BASQUETBOL, Pais.ARGENTINA, false),
        Deportista(4, "Gabriela Sabatini", Deporte.TENIS, Pais.ARGENTINA, true),
        Deportista(5, "Luciana Aymar", Deporte.HOCKEY, Pais.ARGENTINA, false),
        Deportista(6, "Nicolás Massú", Deporte.TENIS, Pais.ARGENTINA, true),
        Deportista(7, "Juan Martín Del Potro", Deporte.TENIS, Pais.ARGENTINA, true),
        Deportista(8, "Paola Egoavil", Deporte.BASQUETBOL, Pais.ARGENTINA, true),
        Deportista(9, "Juan Martín Cúneo", Deporte.HOCKEY, Pais.ARGENTINA, false),
        Deportista(10, "Guido Pella", Deporte.TENIS, Pais.ARGENTINA, false),
        Deportista(11, "Valentina de la Llosa", Deporte.VOLEIBOL, Pais.ARGENTINA, true),

        // Uruguay
        Deportista(8, "Luis Suárez", Deporte.FUTBOL, Pais.URUGUAY, true),
        Deportista(9, "Edinson Cavani", Deporte.FUTBOL, Pais.URUGUAY, true),
        Deportista(10, "José Pedro Furman", Deporte.FUTBOL, Pais.URUGUAY, false),
        Deportista(11, "Natalia Falcón", Deporte.FUTBOL, Pais.URUGUAY, false),
        Deportista(12, "Enzo Francescoli", Deporte.FUTBOL, Pais.URUGUAY, true),
        Deportista(13, "Larisa Collazo", Deporte.JUDO, Pais.URUGUAY, true),
        Deportista(18, "Santiago García", Deporte.FUTBOL, Pais.URUGUAY, false),
        Deportista(19, "Débora Rodríguez", Deporte.BASQUETBOL, Pais.URUGUAY, true),
        Deportista(20, "Marcela Cerviño", Deporte.TENIS, Pais.URUGUAY, false),
        Deportista(21, "Juan Manuel Silva", Deporte.CICLISMO, Pais.URUGUAY, true),

        // Colombia
        Deportista(14, "Radamel Falcao García", Deporte.FUTBOL, Pais.COLOMBIA, false),
        Deportista(15, "Mariana Pajón", Deporte.BMX, Pais.COLOMBIA, true),
        Deportista(16, "Nairo Quintana", Deporte.CICLISMO, Pais.COLOMBIA, true),
        Deportista(17, "Caterine Ibargüen", Deporte.ATLETISMO, Pais.COLOMBIA, true),
        Deportista(18, "Rigoberto Urán", Deporte.CICLISMO, Pais.COLOMBIA, false),
        Deportista(19, "María Camila Osorio Serrano", Deporte.TENIS, Pais.COLOMBIA, false),
        Deportista(28, "Miguel Calvo", Deporte.CICLISMO, Pais.COLOMBIA, false),
        Deportista(29, "Caterine Ibargüen", Deporte.ATLETISMO, Pais.COLOMBIA, true),
        Deportista(30, "Rigoberto Urán", Deporte.CICLISMO, Pais.COLOMBIA, true),
        Deportista(31, "María Camila Osorio Serrano", Deporte.TENIS, Pais.COLOMBIA, false),

        // Chile
        Deportista(20, "Alexis Sánchez", Deporte.FUTBOL, Pais.CHILE, false),
        Deportista(21, "Marcelo Ríos", Deporte.TENIS, Pais.CHILE, true),
        Deportista(22, "Fernando González", Deporte.TENIS, Pais.CHILE, true),
        Deportista(23, "María José López", Deporte.VOLEIBOL, Pais.CHILE, false),
        Deportista(24, "Felipe Campos", Deporte.JUDO, Pais.CHILE, true),
        Deportista(25, "Tomás González", Deporte.GIMNASIA, Pais.CHILE, true),
        Deportista(38, "Fernanda Maciel", Deporte.VOLEIBOL, Pais.CHILE, false),
        Deportista(39, "Lucas Manfredi", Deporte.ATLETISMO, Pais.CHILE, false),
        Deportista(40, "Nicolás Jarry", Deporte.TENIS, Pais.CHILE, true),
        Deportista(41, "Daniela Seguel", Deporte.ATLETISMO, Pais.CHILE, true),

        // Brasil
        Deportista(26, "Pelé", Deporte.FUTBOL, Pais.BRASIL, false),
        Deportista(27, "Neymar Jr", Deporte.FUTBOL, Pais.BRASIL, true),
        Deportista(28, "Ayrton Senna", Deporte.AUTOMOVILISMO, Pais.BRASIL, false),
        Deportista(29, "Marta Vieira da Silva", Deporte.FUTBOL, Pais.BRASIL, false),
        Deportista(30, "Aline Reis", Deporte.VOLEIBOL, Pais.BRASIL, true),
        Deportista(31, "Gustavo Kuerten", Deporte.TENIS, Pais.BRASIL, true),
        Deportista(52, "Leandro Barbosa", Deporte.FUTBOL, Pais.BRASIL, true),
        Deportista(53, "Alessandra Oliveira", Deporte.VOLEIBOL, Pais.BRASIL, true),
        Deportista(54, "Gustavo Kuerten", Deporte.TENIS, Pais.BRASIL, false),
        Deportista(55, "Darragh O'Brien", Deporte.JUDO, Pais.BRASIL, true)
    )

    private val intentHelper = IntentHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //Inicializacion de elementos de UI
        buttonVolver = findViewById(R.id.buttonVolver)
        spinnerPaises = findViewById(R.id.spinner)
        listView = findViewById(R.id.listView)


        //Recuperacion de los elementos "extras" del intent de la anterior actividad, y los guardo en variables
        val bundle = intent.extras
        val nation1 = bundle?.getString("PrimerPais", "")?.uppercase()
        val nation2 = bundle?.getString("SegundoPais", "")?.uppercase()
        val nation3 = bundle?.getString("TercerPais", "")?.uppercase()


        val paises = listOf(nation1, nation2, nation3) //Lista para guardar paises ingresados en la anterior actividad

        //Creacion del adaptador del spinner y se lo asigno al spinner del UI
        val adapterSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, paises)
        spinnerPaises.adapter = adapterSpinner

        //Creacion del adaptador del ListView y se lo asigno al ListView del UI
        val adapterListView = ArrayAdapter(this@SecondActivity, android.R.layout.simple_list_item_1, nombreDeportistas)
        listView.adapter = adapterListView

        //On click listener del spinner
        spinnerPaises.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //Al seleccionar un país, se filtra la lista de deportistas y se actualiza el ListView
                paisSeleccionado = paises[position]
                nombreDeportistas.clear()
                nombreDeportistas.addAll(mostrarDeportistas(paisSeleccionado))
                adapterListView.notifyDataSetChanged()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        //On click listener de los elementos del listView
        listView.setOnItemClickListener { parent, view, position, id ->
            val deportistaSeleccionado = deportistasFiltrados[position] //Obtener el deportista seleccionado

            //Intent para ir a la siguiente actividad (Se podria haber hecho como funcion de la clase IntentHelper, pero no se reusa el codigo, entonces no se si es necesario)
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("idDeportista", deportistaSeleccionado.id)
            intent.putExtra("nombreDeportista", deportistaSeleccionado.nombre)
            intent.putExtra("deporte", deportistaSeleccionado.deporte.name)
            intent.putExtra("pais", deportistaSeleccionado.pais.name)
            intent.putExtra("activo", deportistaSeleccionado.activo)

            startActivity(intent)
        }

        //On click listener del boton "Volver"
        buttonVolver.setOnClickListener {
            finish()
        }
    }

    // Función para filtrar la lista de deportistas por país y obtener una lista con los nombres
    fun mostrarDeportistas(pais: String?): MutableList<String> {

        //Filtrar la lista de deportistas por pais
        deportistasFiltrados = listaDeportistas.filter { it.pais.toString() == pais}
            .toMutableList()

        //Devolver solo los nombres de los deportistas filtrados
        return listaDeportistas
            .filter { it.pais.toString() == pais }
            .map { it.nombre }
            .toMutableList()
    }
}