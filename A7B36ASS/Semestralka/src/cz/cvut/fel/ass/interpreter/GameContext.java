package cz.cvut.fel.ass.interpreter;

// Rozhraní pro manipulaci s hrací plochou
public abstract class GameContext {
	public abstract void put() throws IllegalGameActionException; // Vloží značku
	public abstract void move() throws IllegalGameActionException; // Pohne se ve směru
	public abstract void pick() throws IllegalGameActionException; // zvedne značku
	public abstract void turnLeft() throws IllegalGameActionException; // Otočí se doleva
	public abstract void halt() ;
}
