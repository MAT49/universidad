class TwosController < ApplicationController
  before_action :set_two, only: [:show, :edit, :update, :destroy]

  # GET /twos
  # GET /twos.json
  def index
    @twos = Two.all
  end

  # GET /twos/1
  # GET /twos/1.json
  def show
  end

  # GET /twos/new
  def new
    @two = Two.new
  end

  # GET /twos/1/edit
  def edit
  end

  # POST /twos
  # POST /twos.json
  def create
    @two = Two.new(two_params)

    respond_to do |format|
      if @two.save
        format.html { redirect_to @two, notice: 'Two was successfully created.' }
        format.json { render :show, status: :created, location: @two }
      else
        format.html { render :new }
        format.json { render json: @two.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /twos/1
  # PATCH/PUT /twos/1.json
  def update
    respond_to do |format|
      if @two.update(two_params)
        format.html { redirect_to @two, notice: 'Two was successfully updated.' }
        format.json { render :show, status: :ok, location: @two }
      else
        format.html { render :edit }
        format.json { render json: @two.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /twos/1
  # DELETE /twos/1.json
  def destroy
    @two.destroy
    respond_to do |format|
      format.html { redirect_to twos_url, notice: 'Two was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_two
      @two = Two.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def two_params
      params.require(:two).permit(:first, :second)
    end
end
