package com.aesireanempire.eplus.gui.elements

import com.aesireanempire.eplus.GUIAdvEnchantment
import net.minecraft.util.ResourceLocation

class ScrollBar(posX: Int, posY: Int, width: Int, height: Int, texture: ResourceLocation,
                screen: GUIAdvEnchantment) extends GuiElement(posX,
    posY, width, height, 48, texture, screen) {

    private var element: ListBox = null

    def linkElement(element: ListBox) = {
        this.element = element
    }

    def getNumberOfElementsLinked: Int = {
        element.data.length
    }

    private var scrollPosition = 0

    override def drawExtras() {
        screen.mc.renderEngine.bindTexture(screen.TEXTURE)
        drawTexturedModalRect(posX, posY + scrollPosition, 0, 182, 12, 15)
    }

    override def update() = {}

    override def mouseMoved(x: Int, y: Int): Unit = {
        val newPosition = y - posY - 6
        move(newPosition)
    }

    def move(position: Int) {
        var newPosition = position
        if (position % 14 != 0) {
            val movement = position % 14
            newPosition = position - movement
        }

        if (newPosition < 0) newPosition = 0

        if (newPosition + 12 >= height) newPosition = height - 12

        element.handleMovementChange(newPosition - scrollPosition)

        scrollPosition = newPosition
    }

    override def isVisible: Boolean = true

    override def handleMouseInput(mouseEvent: Int, mouseX: Int, MouseY: Int) = {
        if(mouseEvent != 0)
        {
            val sign = if (mouseEvent < 0) 1 else -1
            move(scrollPosition + sign * 14)
        }
    }
}