/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopokemon;

import Objetos.Jugador;
import Objetos.Pokemon;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dialj
 */
public class Menu {

    private int contador;
    private int contadorJugador;
    private static Pokemon[] poke;
    private static Jugador[] jugadorUno;
    private static Jugador[] jugadorDos;

    // Metodo constructor.
    public Menu() {
        this.contador = 0;
        this.contadorJugador = 0;
        this.poke = new Pokemon[20];
        this.jugadorUno = new Jugador[100];
        this.jugadorDos = new Jugador[100];
        this.pokemonPorDefecto();
    }

    // Metodo que muestra las opciones principales al iniciar el juego.
    public void menuPrincipal() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
        System.out.println("1. Administrador.");
        System.out.println("2. Iniciar Juego.");
        System.out.println("3. Salir.");
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");

        int opcion = 0;
        do {
            System.out.println("Ingrese una opcion : ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    menuAdmon();
                    break;
                case 2:
                    elegirPokemon();
                    break;
                case 3:
                    salir();
                    break;
                default:
                    System.out.println("Opcion Invalida, vuelva a intentarlo... \n");
                    menuPrincipal();
            }
        } while (opcion > 0 && opcion <= 4);
    }

    // Metodo que muestra las opciones del menu administrador.
    private void menuAdmon() {

        int contraseña = 201700770;
        int validarContraseña = 0;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese la contraseña para continuar : ");
        validarContraseña = entrada.nextInt();

        if (contraseña != validarContraseña) {
            System.out.println("Contraseña Invalida, vuelva a intentarlo...");
            menuPrincipal();
        } else {

            System.out.println("\n-.-.-.- Bienvenido Administrador .-.-.-.-.-.-.-.-.-.-.-.-.-.-");
            System.out.println("1. Lista de Pokemon.");
            System.out.println("2. Agregar Pokemon.");
            System.out.println("3. Editar Pokemon.");
            System.out.println("4. Reportes.");
            System.out.println("5. Regresar al Menu Principal.");
            System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");

            int opcion = 0;
            do {
                opcion = entrada.nextInt();
                switch (opcion) {
                    case 1:
                        listarPokemon();
                        break;
                    case 2:
                        agregarPokemon();
                        break;
                    case 3:
                        editarPokemon();
                        break;
                    case 4:
                        break;
                    case 5:
                        menuPrincipal();
                        break;
                    default:
                        System.out.println("Opcion Invalida, vuelva a intentarlo... \n");
                        menuPrincipal();
                }
            } while (opcion > 0 && opcion <= 5);
        }
    }

    // Metodo que muestra las opciones del menu de batallar.
    public void menuBatallar(Jugador jugadorUno, Jugador jugadorDos) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("\n-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
        System.out.println("1. Batallar.");
        System.out.println("2. Finalizar Partida.");
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");

        int opcion = 0;
        do {
            System.out.println("Ingrese una opcion : ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    batallar(jugadorUno, jugadorDos);
                    break;
                case 2:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opcion Invalida, vuelva a intentarlo... \n");
                    menuPrincipal();
            }
        } while (opcion >= 1 && opcion <= 2);
    }

    // Metodo que muestra o lista a todos los pokemon que tenemos en el arreglo.
    private void listarPokemon() {

        int iteracion = 1;
        for (int i = 0; i < this.contador; i++) {

            System.out.println("\n------ Pokemon " + iteracion + " ------");
            System.out.println("Nombre : " + poke[i].getNombre());
            System.out.println("Puntos de Vida : " + poke[i].getVida());
            System.out.println("Puntos de Ataque : " + poke[i].getAtaque());
            System.out.println(poke[i].getImagen());
            System.out.println("");
            iteracion++;
        }
        opcion();
    }

    // Metodo que lista todos los pokemon.
    private void mostrarPokemon() {

        int iteracion = 1;
        for (int i = 0; i < this.contador; i++) {

            System.out.println("\n------ Pokemon " + iteracion + " ------");
            System.out.println("Nombre : " + poke[i].getNombre());
            System.out.println("Puntos de Vida : " + poke[i].getVida());
            System.out.println("Puntos de Ataque : " + poke[i].getAtaque());
            System.out.println(poke[i].getImagen());
            System.out.println("");
            iteracion++;
        }

    }

    // Metodo que permite almacenar o agregar un pokemon nuevo al arreglo.
    private void agregarPokemon() {

        Scanner valor = new Scanner(System.in);
        Random random = new Random();
        String nombre, imagen;

        String estado = "Vivo";
        int vida = (random.nextInt()) * 100 + 50;
        int ataque = (random.nextInt()) * 20 + 5;

        System.out.println("Ingrese el nombre del Pokemon : ");
        nombre = valor.nextLine();

        System.out.println("Ingrese una imagen para del Pokemon : ");
        imagen = valor.nextLine();

        poke[this.contador] = new Pokemon(nombre, vida, estado, ataque, imagen, 0, 0);
        this.contador++;

        System.out.println("¡ Pokemon creado exitosamente !\n");
        opcion();
    }

    // Este metodo que permite editar a cada pokemon que tenemos almacenado en el arreglo.
    private void editarPokemon() {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del Pokemon a modificar : ");
        String nombre = entrada.nextLine().trim();

        for (int i = 0; i < this.contador; i++) {
            if (poke[i].getNombre().equalsIgnoreCase(nombre)) {

                System.out.println("Ingrese el nuevo nombre de su pokemon :");
                String nuevoNombre = entrada.nextLine();
                poke[i].setNombre(nuevoNombre);

                System.out.println("Ingrese el nuevo puntaje de ataque de su pokemon en un rango de [5-20] :");
                int nuevoAtaque = entrada.nextInt();
                while ((nuevoAtaque < 5) || (nuevoAtaque > 20)) {
                    System.out.println("¡ El ataque es mayor o menor al rango especificado por favor vuelva a intentarlo !");
                    nuevoAtaque = entrada.nextInt();
                }
                poke[i].setVida(nuevoAtaque);

                System.out.println("Ingrese el nuevo puntaje de vida de su pokemon en un rango de [50-100] :");
                int nuevaVida = entrada.nextInt();
                while ((nuevaVida < 50) || (nuevaVida > 100)) {
                    System.out.println("¡ La vida es mayor o menor al rango especificado, por favor vuelva a intentarlo !");
                    nuevaVida = entrada.nextInt();
                }
                poke[i].setVida(nuevaVida);

                System.out.println("¡ Pokemon modificado exitosamente !\n");
                break;
            }
        }
        opcion();

    }

    // Este metodo permite almanecar en un vector a los jugadores.
    private void elegirPokemon() {

        Scanner entrada = new Scanner(System.in);
        int numeroAleatorio = (int) (Math.random() * (2));

        System.out.println("Ingrese el nombre del primer Jugador :");
        String nombreUno = entrada.nextLine();

        System.out.println("Ingrese el nombre del segundo Jugador :");
        String nombreDos = entrada.nextLine();

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("----------------------- Lista de Pokemon ----------------------------------------------");
        mostrarPokemon();
        System.out.println("");

        System.out.println("Jugador " + nombreUno + " eliga su primer pokemon ingresando el nombre : ");
        String eleccionUno = entrada.nextLine();
        Pokemon miPokemonUno = elegirPokemon(eleccionUno);

        System.out.println("Jugador " + nombreUno + " eliga su segundo pokemon ingresando el nombre : ");
        String eleccionDos = entrada.nextLine();
        Pokemon miPokemonDos = elegirPokemon(eleccionDos);

        System.out.println("\nJugador " + nombreDos + " eliga su primer pokemon ingresando el nombre : ");
        String eleccionTres = entrada.nextLine();
        Pokemon miPokemonTres = elegirPokemon(eleccionTres);

        System.out.println("Jugador " + nombreDos + " eliga su segundo pokemon ingresando el nombre : ");
        String eleccionCuatro = entrada.nextLine();
        Pokemon miPokemonCuatro = elegirPokemon(eleccionCuatro);

        this.jugadorUno[this.contadorJugador] = new Jugador(nombreUno, miPokemonUno, miPokemonDos, 0, "");
        this.jugadorDos[this.contadorJugador] = new Jugador(nombreDos, miPokemonTres, miPokemonCuatro, 0, "");

        Jugador uno = this.jugadorUno[this.contadorJugador];
        Jugador dos = this.jugadorDos[this.contadorJugador];

        this.contadorJugador++;

        if (numeroAleatorio == 1) {
            menuBatallar(uno, dos);
        } else {
            menuBatallar(dos, uno);
        }

    }

    private void batallar(Jugador jugadorUno, Jugador jugadorDos) {

        Scanner entrada = new Scanner(System.in);
        Pokemon pokeUno = null, pokeDos = null, pokeTres = null, pokeCuatro = null;
        int contadorAtaqueUno = 0;
        int contadorAtaqueDos = 0;

        while ((jugadorUno.getPokemon().getVida() > 0 || jugadorUno.getPokemonDos().getVida() > 0) && (jugadorDos.getPokemon().getVida() > 0 || jugadorDos.getPokemonDos().getVida() > 0)) {

            System.out.println("\nJugador " + jugadorUno.getNombre() + " ¿ con que pokemon desea atacar ?");
            pokeUno = jugadorUno.elegirPokemonDeAtaque(jugadorUno);

            System.out.println("\nJugador " + jugadorUno.getNombre() + " ¿ a que pokemon desea atacar ?");
            pokeTres = jugadorDos.elegirPokemonAtacar(jugadorDos);
            contadorAtaqueUno++;

            if (!(jugadorDos.getPokemon().getVida() < 0) && (pokeTres.equals(jugadorDos.getPokemon()))) {

                int ataque = pokeUno.getAtaque();
                int vida = pokeTres.getVida();
                int total = vida - ataque;

                System.out.println("----------- ATACANDO --------------");
                System.out.println(pokeUno.getNombre() + " esta atacando a " + pokeTres.getNombre());
                System.out.println("Actualmente " + pokeTres.getEstado());
                System.out.println("Vida " + pokeTres.getVida());
                System.out.println("Ataque " + pokeTres.getAtaque());
                pokeTres.setVida(total);
                jugadorUno.setNumeroAtaque(contadorAtaqueUno);
                System.out.println("¡ Ataque realizado exitosamente !");
                System.out.println("El pokemon " + pokeTres.getNombre() + " quedo con una vida actual de " + pokeTres.getVida() + "\n");

            } else if (!(jugadorDos.getPokemonDos().getVida() < 0) && (pokeTres.equals(jugadorDos.getPokemonDos()))) {

                int ataque = pokeUno.getAtaque();
                int vida = pokeTres.getVida();
                int total = vida - ataque;

                System.out.println("----------- ATACANDO --------------");
                System.out.println(pokeUno.getNombre() + " esta atacando a " + pokeTres.getNombre());
                System.out.println("Actualmente " + pokeTres.getEstado());
                System.out.println("Vida " + pokeTres.getVida());
                System.out.println("Ataque " + pokeTres.getAtaque());
                pokeTres.setVida(total);
                jugadorUno.setNumeroAtaque(contadorAtaqueUno);
                System.out.println("¡ Ataque realizado exitosamente !");
                System.out.println("El pokemon " + pokeTres.getNombre() + " quedo con una vida actual de " + pokeTres.getVida() + "\n");

            } else {

                if (jugadorDos.getPokemon().getVida() < 0) {

                    System.out.println("------------MUERTO--------------");
                    System.out.println("" + pokeTres.getNombre());
                    pokeTres.setEstado("Muerto");
                    System.out.println("¡ Pokemon " + pokeTres.getNombre() + " demasiado debil, este pokemon ya no puede continuar !");

                }
                if (jugadorDos.getPokemonDos().getVida() < 0) {

                    System.out.println("------------MUERTO--------------");
                    System.out.println("" + pokeTres.getNombre());
                    pokeTres.setEstado("Muerto");
                    System.out.println("¡ Pokemon " + pokeTres.getNombre() + " demasiado debil, este pokemon ya no puede continuar !");
                }

            }

            System.out.println("\nJugador " + jugadorDos.getNombre() + " ¿ con que pokemon desea atacar ?");
            pokeDos = jugadorDos.elegirPokemonDeAtaque(jugadorDos);

            System.out.println("\nJugador " + jugadorDos.getNombre() + " ¿ a que pokemon desea atacar ?");
            pokeCuatro = jugadorUno.elegirPokemonAtacar(jugadorUno);
            contadorAtaqueDos++;

            if (!(jugadorUno.getPokemon().getVida() < 0) && (pokeCuatro.equals(jugadorUno.getPokemon()))) {

                int ataque = pokeDos.getAtaque();
                int vida = pokeCuatro.getVida();
                int total = vida - ataque;

                System.out.println("----------- ATACANDO --------------");
                System.out.println(pokeDos.getNombre() + " esta atacando a " + pokeCuatro.getNombre());
                System.out.println("Actualmente " + pokeCuatro.getEstado());
                System.out.println("Vida " + pokeCuatro.getVida());
                System.out.println("Ataque " + pokeCuatro.getAtaque());
                pokeCuatro.setVida(total);
                jugadorDos.setNumeroAtaque(contadorAtaqueDos);
                contadorAtaqueDos++;
                System.out.println("¡ Ataque realizado exitosamente !");
                System.out.println("Vida actualizada " + pokeCuatro.getVida() + "\n");
                System.out.println("El pokemon " + pokeCuatro.getNombre() + " quedo con una vida actual de " + pokeCuatro.getVida() + "\n");

            } else if (!(jugadorUno.getPokemonDos().getVida() < 0) && (pokeCuatro.equals(jugadorUno.getPokemonDos()))) {

                int ataque = pokeDos.getAtaque();
                int vida = pokeCuatro.getVida();
                int total = vida - ataque;

                System.out.println("----------- ATACANDO --------------");
                System.out.println(pokeDos.getNombre() + "esta atacando a " + pokeCuatro.getNombre());
                System.out.println("Actualmente " + pokeCuatro.getEstado());
                System.out.println("Vida " + pokeCuatro.getVida());
                System.out.println("Ataque " + pokeCuatro.getAtaque());
                pokeCuatro.setVida(total);
                jugadorDos.setNumeroAtaque(contadorAtaqueDos);
                System.out.println("¡ Ataque realizado exitosamente !");
                System.out.println("Vida actualizada " + pokeCuatro.getVida() + "\n");
                System.out.println("El pokemon " + pokeCuatro.getNombre() + " quedo con una vida actual de " + pokeCuatro.getVida() + "\n");

            } else {

                if (jugadorUno.getPokemon().getVida() < 0) {

                    System.out.println("------------MUERTO--------------");
                    System.out.println("" + pokeCuatro.getNombre());
                    pokeCuatro.setEstado("Muerto");
                    System.out.println("¡ Pokemon " + pokeCuatro.getNombre() + " demasiado debil, este pokemon ya no puede continuar !");

                }
                if (jugadorUno.getPokemonDos().getVida() < 0) {
                    System.out.println("------------MUERTO--------------");
                    System.out.println("" + pokeCuatro.getNombre());
                    pokeCuatro.setEstado("Muerto");
                    System.out.println("¡ Pokemon " + pokeCuatro.getNombre() + " demasiado debil, este pokemon ya no puede continuar !");
                }

            }

        } 

        if (jugadorUno.getPokemon().getEstado().equals("Muerto") && jugadorUno.getPokemonDos().getEstado().equals("Muerto")) {
            System.out.println("¡ Jugador " + jugadorDos.getNombre() + " felicitaciones has ganado la batalla !");
            jugadorDos.setEstado("Ganador");
            menuPrincipal();
        } else if (jugadorDos.getPokemon().getEstado().equals("Muerto") && jugadorDos.getPokemonDos().getEstado().equals("Muerto")) {
            System.out.println("¡ Jugador " + jugadorUno.getNombre() + " felicitaciones has ganado la batalla !");
            jugadorUno.setEstado("Ganador");
            menuPrincipal();
        }

    }

    // Este metodo recibe como parametro el nombre del pokemon para luego buscarlo en el arreglo y de encontrarlo retornara el pokemon en caso contrario retornara un null.
    private Pokemon elegirPokemon(String pokemon) {

        Scanner entrada = new Scanner(System.in);
        Pokemon retorno = null;
        for (int i = 0; i < this.contador; i++) {
            if (poke[i].getNombre().equalsIgnoreCase(pokemon)) {
                retorno = poke[i];
                return retorno;
            }
        }

        if (retorno == null) {
            System.out.println("¡ El nombre del pokemon " + pokemon + " esta incorrecto o no existe, vuelva a intentarlo !\n");
            System.out.println("Ingrese el nombre de su pokemon nuevamente : ");
            String nombrePokemon = entrada.nextLine();
            elegirPokemon(nombrePokemon);
        }
        return retorno;
    }

    // Este metodo que almacena a 6 pokemon por defecto, este metodo se inicializa al iniciar la ejecucion del programa.
    private void pokemonPorDefecto() {

        poke[this.contador] = new Pokemon("Cyndaquil", 100, "Vivo", 20, "\n"
                + "                                  *                         \n"
                + "                           ,      **                        \n"
                + "                           **    ***                        \n"
                + "            **             *** * ****                       \n"
                + "  ***         ****    *    **********   **                  \n"
                + "    ,*******  * ********** *******/*******,,,,.             \n"
                + "       **************(**********/*%%***,,,,,,,,,,,,,        \n"
                + "         ****%*********/%%******&%%%*,&&&&&&&,,,,,,,,,      \n"
                + "        *, /****%%%%*****%%%%%((%%%..&&&&&&&&&&&,,,,,,,     \n"
                + "           ,*******%%%%%%%%...,% ,,..&&&&&&&& &&&...,,,     \n"
                + "              ,**(/**#%%%%%.,,,,,,,,,.&&&&&&&&&&&&....,,    \n"
                + "               ******%%,,,,,,,&&&&&&&&&&&&&&&&&&&&&&&&.,,.  \n"
                + "             ******** ,,,,,,&&&&&&&&&&(&&&&&& .%&&&&&&&&&,, \n"
                + "          **********.,/&&&&&&&&&&%(%% #&&&*%%%&&     &&&&&&,\n"
                + "                    ,%&&&&&&&&&&&&&&&&&&&               ,&&.\n"
                + "                     %%%%&&&&&&%%%%%%%%%&                   \n"
                + "                      /%%%%%%%%  %%%%%%&,                   \n"
                + "                        %%%,%       %%%.                    ", 0, 0);

        this.contador++;
        poke[this.contador] = new Pokemon("Chikorita", 100, "Vivo", 20, "                                                            \n"
                + "                               #@@@@@&,                     \n"
                + "                         @((((((((//////((@#%&              \n"
                + "                      @(#@     ,@###((////(((@#((#          \n"
                + "                     (%            @##(((//((((&#((&        \n"
                + "                  @@&&@@@           @##(((((((((@##((@      \n"
                + "             @,.....,,,,,,,,,@       @##(((((((((###(((     \n"
                + "           @........,,,,,,,,,,,@     @##((((((((((###(((    \n"
                + "          %.......,,,,,@@*,,,,,*@     ###((((((((((###(((   \n"
                + "         @ @#,,,,,,,,@%%@ #,,,,,*@    @###((((((((((@#(((@  \n"
                + "          % @,,,,,,,,# /%@ %,,,,*#     %###((((((((((##(((  \n"
                + "        % %%@,,,,,,,,%%%## @,,,,*/      @#####(#((###@####  \n"
                + "        & //@,,,,,,,,/((/% @,,,,*//      .################  \n"
                + "        @,,,,,,,,,,,,,,,,,,,,,,,*/@         @#############  \n"
                + "        (,,,,,,,,,*,,,,,,,,,,,,,,*@@@/         &######&##@  \n"
                + "         ..,,,,,,,,,,,,,,,,,,,,,*/(#@&           %####%##   \n"
                + "        @..,,,,,,,,,,,,,,,,(((@,**//*****         @#####    \n"
                + "        @.,#((*,,,&((%,,,,,,//****//*******@%      @#@@     \n"
                + "         ,.,**,,,,,*/,,,,,,,,,,***/*********%**/    @       \n"
                + "         @,,,,...,,,,,,,,,,,,,,***//****///**@/@            \n"
                + "          *,,,,....,,,,,,,,,,,,***////////////@             \n"
                + "           ,,*#**,,,,,,,,,,,,,,**/////////////              \n"
                + "           .***///&///**/,,,,,,*@//(/////////(              \n"
                + "             ***///    *@,,,,,*%%%@@/(//////@               \n"
                + "            @,**@        @@**@@@      @(*/(                 \n"
                + "                          *,,@                              \n"
                + "                                              ", 0, 0);

        this.contador++;
        poke[this.contador] = new Pokemon("Totodile", 100, "Vivo", 20, "                                                             \n"
                + "                   ###  # ########(                         \n"
                + "                #######(#############                       \n"
                + "              ######## #### @@@@ #####                      \n"
                + "             ,####### #### @ /@@@, ####                     \n"
                + "             ####### ####  @  @@@., #### ((                 \n"
                + "           ####### ##### , @ ,@@@,, #####*(((((             \n"
                + "      ####### ######### ,,,@@ @  ######## (((((*            \n"
                + "  ####################################### (((               \n"
                + " ##### ######################* ########## (((((             \n"
                + " ################  ###################### (((((((((((       \n"
                + "  ########  @@ ############# ############ (((((((((((       \n"
                + "     ### ####  ######### ######   ####### ((((((((          \n"
                + "                   ##### /@@@@@@ #########((((              \n"
                + "               # @@@.@@@@@@@@@@@########## ((((((((         \n"
                + "             ## @@@.@@@@@@@@@@@ ########*##,(((((           \n"
                + "            ## #@@@@@@@@@ (####(######## ###,((,            \n"
                + "          ### ### @@  #########(########*####               \n"
                + "          ### ################# ####### #######        (    \n"
                + "          ##################### ########### #####  (((((    \n"
                + "          ##################.#.#####/## #### ######## *(    \n"
                + "           ######.######################################### \n"
                + "            ########  ###### ################.###########   \n"
                + "           ### ##########      #############                \n"
                + "        ####  #########           ########                  \n"
                + "         ######                   ###### ##,                \n"
                + "                                 ######## ###               \n"
                + "                                 ###(####.##( ", 0, 0);

        this.contador++;
        poke[this.contador] = new Pokemon("Charizard", 80, "Vivo", 16, "                                          *                 \n"
                + "                (***#           ,(  /     **&/*(            \n"
                + "           ,**#%%%%%**          *****(   /*%&%##%&*         \n"
                + "         */%%%%##%&%%.         *(*.***   *%###%####%((      \n"
                + "       *%%%#####%%%#%%*.      **(((***  .%%####%#####%%/    \n"
                + "    **%%%#######%%####%%/.**..**((,  .*&%%#####%########%*  \n"
                + "   (%%####%(/###%%########./***(((((%%#########&%        (%*\n"
                + "  *%#          #%%#%*,(**(%*((((%//#(/%##%     %            \n"
                + " &              &      #*(**((********#(((*#% (             \n"
                + "  (  /                  ((*(**********#                     \n"
                + "   ....../    (..,.. (./****#*********#**.                  \n"
                + "     (.#*((,(//(**%(/********#********(***.                 \n"
                + "                     ./((((((/******(((((((                 \n"
                + "                        (((%        (((%(                   \n"
                + "                      ,****.          ****                  \n"
                + "                                       .  .   ", 0, 0);
        this.contador++;
        poke[this.contador] = new Pokemon("Gengar", 100, "Vivo", 20, ""
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&@@@@@@@@@\n"
                + "@@@@@@#@@@@@@@@@@@@@@@@@@@@@&#@@@@@@@@@@@@@@@&((/#@@@@@@@@@@\n"
                + "@@@@@@@(((#&@@@@@@@@@@@@@@@%(/@@@@@@@@@@@%#(((/*%@@@@@@@@@@@\n"
                + "@@@@@@@&#(((((#%@@@@@&@&#%((//#(/@@((%#(((((/**&@@@@@@@@@@@@\n"
                + "@@@@@@@@@#(((((((((##(#(((((((((((((((((((//**@@@@@@@@@@@@@@\n"
                + "@@@@@@@@@&#((((((((((((((((((((((((((((///***@@@@@@@@@@@@@@@\n"
                + "@@@@@@@@@@&#(((((((((((((((((((((((((////***((@@@@@@@@@@@@@@\n"
                + "@@@@@@@@@@@%(((((((((((((((((((((((((////*****@@@@@@@@@@@@@@\n"
                + "@@@@@@@@@@@#((((((((((((((((((((((((((/////*///&@@@@@@@@@@@@\n"
                + "@@@@@@@@@##(((((((((((((((((((((*((((/////////////#@@@@@@@@@\n"
                + "@@@@@&%(/(#((*%/(((((((((((((,%%*(((////////////////(@@@@@@@\n"
                + "@@@@%////((((/%%.*((((((((//,%%%,/////////*///////////(@@@@@\n"
                + "@@@#/////#(/(((%%%%*((((/(%%%#/*////,/////**////////////@@@@\n"
                + "@@#((///*#((&(/(((((((((((((//*/(%%%/////*****///////////(@@\n"
                + "@#((//***((((&@@@@#@@@#@@&@(&&&&(%#//////********////////*/@\n"
                + "@#(/****&@#(((/&@@%@@@@@@&&%&&&&(//////**********(@@&//*/*@@\n"
                + "@@/&@@@@@@@((((((/(#%%&(%#(//////////************@@@@@@@@@@@\n"
                + "@@@@@@@@@@@@((((//////////////////***************@@@@@@@@@@@\n"
                + "@@@@@@@@@@&#((///////////////**************,****/@@@@@@@@@@@\n"
                + "@@@@@@@@@&(///////////*****************,,,******(@@@@@@@@@@@\n"
                + "@@@@@@@@#(///**********************,,,,,,*******%@@@@@@@@@@@\n"
                + "@@@@@@@@#//****,,,,,,*************,,,,**********@@@@@@@@@@@@\n"
                + "@@@@@@@%(/***,,,,,,,#@@@@@@@@@@@@@@@@**********&@@@@@@@@@@@@\n"
                + "@@@@@@@@@@@%/&@@@@@@@@@@@@@@@@@@@@@@@@@********/@@@@@@@@@@@@", 0, 0);

        this.contador++;
        poke[this.contador] = new Pokemon("Chansey", 100, "Vivo", 18, ""
                + "                       #&&&&&&&&&&&&&/                      \n"
                + "                   ,&&&&&&&&&&&&&&&&&&&&&                   \n"
                + "       ...   .%&&&&&&&&&&*,&&&&&&/@&&&&&&&&&&&,   ....      \n"
                + "       %%%%&(*&&&&&&&&&&&//&&&&&&& &&&&&&&&&&&#,&#%%%,      \n"
                + "        /%&&%%&&&&&&&&&&&&&&*..,&&&&&&&&&&&&&&&,&&&#.       \n"
                + "    %%%%#%.&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&#,%%%%%*   \n"
                + "       (#%%#,&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&.#%%%%       \n"
                + "      ### &&&&&&&&&&&&&&&.&&&( &&&,%&&&&&&&&&&&&&&.(%#/     \n"
                + "        &&&&&&&&&&&&&&&&&&&&&.&&&&&&&&&&&&&&&&&&&&&&*       \n"
                + "       &&&&&&&&&&&&&&&&&&&&,&&&&*&&&&&&&&&&&&&&&&&&&&#      \n"
                + "      &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&*     \n"
                + "     &&&&&&&&&&&&&&&&&&&& @@@@@@@@ %&&&&&&&&&&&&&&&&&&&     \n"
                + "     &&&&&&&&&&&&&&&&&&/@@@@@@@@@@@@@*&&&&&&&&&&&&&&&&&*    \n"
                + "     &&&&&&&&&&&&&&&& @@@@@@@@@@@@@@@@,&&&&&&&&&&&&&&&&#    \n"
                + "     &&&&&&&&&&&&&&&.@@@@@@@@@@@@@@@@@@,&&&&&&&&&&&&&&&/    \n"
                + "     &&&&&&&&&&&&&&(..(@@@@@@@@@@@@@@&/ .&&&&&&&&&&&&&%     \n"
                + "     .&&&&&&&&&&&&&%%%%%%%%%%%%%%%%%%%%# &&&&&&&&&&&&%#     \n"
                + "      .&&&&&&&&&&&&& #%%%%%%%%%%%%%%%%#*&&&&&&&&&&&%%%      \n"
                + "        %&&&&&&&&&&&&,(%%%%%%%%%%%%%## &&&&&&&&&&%%%.       \n"
                + "          /&&&&&&&&&&&&# ((########.,&&&&&&&&&&%%%          \n"
                + "              %%&&&&&&&&&&&&&&&&&&&&&&&&&&&%%%%             \n"
                + "            ##%##  *%%%%&&&&&&&&&&&%%%%%%, *%%%%            \n"
                + "          %%%#%##(,                       /##%%%%#.    ", 0, 0);
        this.contador++;
    }

    // Metodo
    private void opcion() {

        Scanner entrada = new Scanner(System.in);
        System.out.println("¿ Desea continuar en el menu administrador ?");
        String opcion = entrada.nextLine();
        if (opcion.equalsIgnoreCase("si")) {
            menuAdmon();
        } else {
            menuPrincipal();
        }
    }

    // Este metodo que permite finalizar la ejecucion del programa.
    private void salir() {
        System.out.println("Ejecucion del programa finalizada, gracias por jugar Pokemon");
        System.exit(0);
    }

    /**
     * @return the contador
     */
    public int getContador() {
        return contador;
    }

    /**
     * @param contador the contador to set
     */
    public void setContador(int contador) {
        this.contador = contador;
    }

}
