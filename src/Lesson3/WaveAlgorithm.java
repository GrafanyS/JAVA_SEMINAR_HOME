package Lesson3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WaveAlgorithm {
    public WaveAlgorithm(int[][] map) {
    }

    public static void main(String[] args) {
        //Печать карты
        var mg = new MapGenerator();
        //Установление координат начальной точки - 1
        Point ps = new Point(3, 3);
        mg.setStart(ps);
        System.out.println("Пустая карта K - начало маршрута");
        System.out.println(new MapPrinter().mapColor(mg.getMap())

        );

        var lee = new Algorithm(mg.getMap());
        lee.SpreadWave(new Point(3, 3));
        System.out.println("Заполненная карта после оцифровки волновым алгоритмом");
        System.out.println(new MapPrinter().rawData(mg.getMap())

        );
        //Нанесение на карьу маршрута с начальной точки 1 до конечной 19
        var rd = lee.getRoad(mg.setExit(19));
        lee.drawRoad(rd);
        System.out.println("Заполненная карта с маршрутом");
        System.out.println(new MapPrinter().mapColor(mg.getMap()));

    }
}

class Algorithm {
    int[][] map;

    public Algorithm(int[][] map) {
        this.map = map;
    }

    // Волновая оцифровка поля от точки старта
    public void SpreadWave(Point startPoint) {
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(startPoint);
        map[startPoint.x][startPoint.y] = 1;

        while (queue.size() != 0) {
            Point p = queue.remove();

            if (map[p.x - 1][p.y] == 0) {
                queue.add(new Point(p.x - 1, p.y));
                map[p.x - 1][p.y] = map[p.x][p.y] + 1;
            }
            if (map[p.x][p.y - 1] == 0) {
                queue.add(new Point(p.x, p.y - 1));
                map[p.x][p.y - 1] = map[p.x][p.y] + 1;
            }
            if (map[p.x + 1][p.y] == 0) {
                queue.add(new Point(p.x + 1, p.y));
                map[p.x + 1][p.y] = map[p.x][p.y] + 1;
            }
            if (map[p.x][p.y + 1] == 0) {
                queue.add(new Point(p.x, p.y + 1));
                map[p.x][p.y + 1] = map[p.x][p.y] + 1;
            }
        }
    }

    // Формирование массива точек машрута от конечной до начальной точки
    public ArrayList<Point> getRoad(Point exitPoint) {
        ArrayList<Point> road = new ArrayList<>();
        road.add(new Point(exitPoint.x, exitPoint.y));
        Point p = exitPoint;
        while (map[p.x][p.y] > 1) {

            if (map[p.x - 1][p.y] < map[p.x][p.y] && map[p.x - 1][p.y] > 0) {
                p.x -= 1;
                road.add(new Point(p.x, p.y));
            }
            if (map[p.x][p.y - 1] < map[p.x][p.y] && map[p.x][p.y - 1] > 0) {
                p.y -= 1;
                road.add(new Point(p.x, p.y));
            }
            if (map[p.x + 1][p.y] < map[p.x][p.y] && map[p.x + 1][p.y] > 0) {
                p.x += 1;
                road.add(new Point(p.x, p.y));
            }
            if (map[p.x][p.y + 1] < map[p.x][p.y] && map[p.x][p.y + 1] > 0) {
                p.y += 1;
                road.add(new Point(p.x, p.y));
            }
        }
        return road;
    }

    //
    // Расстановка массива точек машрута на карте
    public void drawRoad(ArrayList<Point> rd) {
        for (int i = 0; i < rd.size(); i++) {
            map[rd.get(i).x][rd.get(i).y] = 0;
        }
    }
    //
}
