import { Component } from '@angular/core';
import { FirstLevelMenu, SecondLevelElectronicsMenu, SecondLevelFashionMenu, SecondLevelHomeMenu, SecondLevelSportsMenu } from 'src/app/interface/navbar-menus';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  mainMenu = FirstLevelMenu;
  homeMenus = SecondLevelHomeMenu;
  electronicsMenus = SecondLevelElectronicsMenu;
  fashionMenus = SecondLevelFashionMenu;
  sportsMenus = SecondLevelSportsMenu;

  mainmenus() : Array<string> {
    return Object.keys(this.mainMenu);
  }

  homemenus() : Array<string> {
    return Object.keys(this.homeMenus);
  }

  electronicsmenus() : Array<string> {
    return Object.keys(this.electronicsMenus);
  }

  fashionmenus() : Array<string> {
    return Object.keys(this.fashionMenus);
  }

  sportsmenus() : Array<string> {
    return Object.keys(this.sportsMenus);
  }

}
